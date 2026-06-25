interface Document {
  void open();
}

// 2. Create Concrete Document Classes
class WordDocument implements Document {
  @Override
  public void open() {
    System.out.println("Opening Word Document...");
  }
}

class PdfDocument implements Document {
  @Override
  public void open() {
    System.out.println("Opening PDF Document...");
  }
}

class ExcelDocument implements Document {
  @Override
  public void open() {
    System.out.println("Opening Excel Document...");
  }
}

// 3. Implement the Factory Method Base
abstract class DocumentFactory {
  // This is the Factory Method
  public abstract Document createDocument();
}

// 4. Create Concrete Factory Classes for each document type
class WordFactory extends DocumentFactory {
  @Override
  public Document createDocument() {
    return new WordDocument();
  }
}

class PdfFactory extends DocumentFactory {
  @Override
  public Document createDocument() {
    return new PdfDocument();
  }
}

class ExcelFactory extends DocumentFactory {
  @Override
  public Document createDocument() {
    return new ExcelDocument();
  }
}

// 5. Testing Implementation
public class FactoryMethodPatternExample {
  public static void main(String[] args) {

    // Instantiate the specific factories
    DocumentFactory wordFactory = new WordFactory();
    DocumentFactory pdfFactory = new PdfFactory();
    DocumentFactory excelFactory = new ExcelFactory();

    // Let the factories handle the object creation
    Document doc1 = wordFactory.createDocument();
    Document doc2 = pdfFactory.createDocument();
    Document doc3 = excelFactory.createDocument();

    // Verify the created objects work
    doc1.open();
    doc2.open();
    doc3.open();

    System.out.println("\nSUCCESS: All documents created via Factory Method.");
  }
}
