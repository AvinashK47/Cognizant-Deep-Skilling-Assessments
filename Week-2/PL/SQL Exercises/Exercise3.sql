--Scenario 1 

CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest AS
BEGIN
    -- 1. Execute a bulk update for all savings accounts
    -- Calculates 1% interest and adds it to the current balance
    UPDATE Accounts
    SET balance = balance * 1.01
    WHERE account_type = 'Savings';

    -- 2. Print the number of accounts updated for logging purposes
    DBMS_OUTPUT.PUT_LINE('Monthly interest processed successfully for ' || SQL%ROWCOUNT || ' savings accounts.');
    
    -- 3. Commit the transaction to persist changes
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        -- Rollback changes if an unexpected error occurs to ensure data integrity
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error processing monthly interest: ' || SQLERRM);
END ProcessMonthlyInterest;
/


--we can execute by 
EXEC ProcessMonthlyInterest;





--Scenario 2

CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_department_id IN NUMBER,
    p_bonus_percentage IN NUMBER
) AS
BEGIN
    -- 1. Update salary by multiplying it by (1 + bonus_percentage / 100)
    UPDATE Employees
    SET salary = salary * (1 + (p_bonus_percentage / 100))
    WHERE department_id = p_department_id;

    -- 2. Log performance metrics
    DBMS_OUTPUT.PUT_LINE('Bonus applied. Total employees updated: ' || SQL%ROWCOUNT);
    
    COMMIT;
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error updating employee bonuses: ' || SQLERRM);
END UpdateEmployeeBonus;
/



--we can execute by 
-- Applies a 5% bonus to department ID 10
EXEC UpdateEmployeeBonus(10, 5);




--Scenraio 3 

CREATE OR REPLACE PROCEDURE TransferFunds (
    p_source_account_id IN NUMBER,
    p_destination_account_id IN NUMBER,
    p_amount IN NUMBER
) AS
    v_source_balance NUMBER;
BEGIN
    -- 1. Input Validation: Ensure the transfer amount is positive
    IF p_amount <= 0 THEN
        RAISE_APPLICATION_ERROR(-20001, 'Transfer amount must be greater than zero.');
    END IF;

    -- 2. Fetch and lock the source account row to prevent concurrent overdrafts (Race Conditions)
    SELECT balance INTO v_source_balance
    FROM Accounts
    WHERE account_id = p_source_account_id
    FOR UPDATE;

    -- 3. Business Logic: Check for sufficient funds
    IF v_source_balance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20002, 'Insufficient balance in the source account. Transfer aborted.');
    END IF;

    -- 4. Execution Step A: Debit the source account
    UPDATE Accounts
    SET balance = balance - p_amount
    WHERE account_id = p_source_account_id;

    -- 5. Execution Step B: Credit the destination account
    UPDATE Accounts
    SET balance = balance + p_amount
    WHERE account_id = p_destination_account_id;

    -- 6. Confirm transaction completion
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Successfully transferred $' || p_amount || ' from Account ' || p_source_account_id || ' to Account ' || p_destination_account_id);

EXCEPTION
    -- Catch the custom or runtime exceptions
    WHEN NO_DATA_FOUND THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error: One or both account IDs do not exist.');
    WHEN OTHERS THEN
        ROLLBACK;
        -- Reraise the custom application error message so the calling application gets the exact failure details
        IF SQLCODE BETWEEN -20999 AND -20000 THEN
            DBMS_OUTPUT.PUT_LINE('Transaction Failed: ' || SQLERRM);
        ELSE
            DBMS_OUTPUT.PUT_LINE('Unexpected System Error: ' || SQLERRM);
        END IF;
END TransferFunds;
/


--execute by 
-- Attempts to transfer $500 from account 1001 to account 1002
EXEC TransferFunds(1001, 1002, 500);
