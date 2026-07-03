--Scenario 1 

DECLARE
    -- 1. Declare a cursor to fetch all customers and their associated loans
    -- The FOR UPDATE clause locks these specific rows during the transaction
    CURSOR customer_loans_cur IS
        SELECT c.customer_id, c.age, l.loan_id, l.interest_rate 
        FROM Customers c
        JOIN Loans l ON c.customer_id = l.customer_id
        FOR UPDATE OF l.interest_rate;
BEGIN
    -- 2. Iterate through each record fetched by the cursor
    FOR rec IN customer_loans_cur LOOP
        -- 3. Control Structure: Check the age condition
        IF rec.age > 60 THEN
            -- 4. Apply the 1% discount to the current row
            UPDATE Loans
            SET interest_rate = interest_rate - 1
            WHERE CURRENT OF customer_loans_cur; -- Updates exactly where the cursor is currently pointing
        END IF;
    END LOOP;
    
    -- 5. Commit the transaction to save changes permanently
    COMMIT; 
END;
/




-- Scenario 2

DECLARE
    -- 1. Declare a cursor to check customer balances
    CURSOR vip_cur IS
        SELECT customer_id, balance, IsVIP 
        FROM Customers 
        FOR UPDATE OF IsVIP;
BEGIN
    -- 2. Loop through all customers in the database
    FOR rec IN vip_cur LOOP
        -- 3. Control Structure: Check if balance exceeds the $10,000 threshold
        IF rec.balance > 10000 THEN
            -- 4. Update the flag for the current cursor row
            -- (Note: Oracle PL/SQL typically uses 'Y'/'N' or 1/0 for booleans in tables)
            UPDATE Customers
            SET IsVIP = 'TRUE' 
            WHERE CURRENT OF vip_cur;
        END IF;
    END LOOP;
    
    -- 5. Commit the transaction
    COMMIT;
END;
/



--Scenario 3

DECLARE
    -- 1. Declare a cursor filtering directly in the SQL engine (more efficient than filtering in PL/SQL)
    -- SYSDATE is the current system date. SYSDATE + 30 adds exactly 30 days.
    CURSOR due_loans_cur IS
        SELECT c.customer_name, l.loan_id, l.due_date
        FROM Loans l
        JOIN Customers c ON l.customer_id = c.customer_id
        WHERE l.due_date BETWEEN SYSDATE AND (SYSDATE + 30);
BEGIN
    -- 2. Loop through only the records that matched the date criteria
    FOR rec IN due_loans_cur LOOP
        -- 3. Print the reminder message to the server output using concatenation (||)
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || rec.customer_name || 
                             ', your loan (' || rec.loan_id || 
                             ') is due on ' || TO_CHAR(rec.due_date, 'YYYY-MM-DD'));
    END LOOP;
END;
/