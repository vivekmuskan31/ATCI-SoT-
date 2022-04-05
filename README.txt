# ATCI-SoT-

[WARNING] : ShoppinCart : Please change the filepath of "store-items.csv" and "receipt.txt" when running localhost
            To change, navigate to "ShoppingCart/src/com/accenture/shopping/project/Store.java"
                1. In method "shop() [Line: 111]" -> readStoreItem(`your_full_file_path_for_store-items.csv`)
                2. In method "shop() [Line: 144]" -> saveReceiptToFile(`your_full_file_path_for_receipt.txt`)

# Folder Structure and Exercise Location

|---CodingExerciseI
|     |
|     |--- out/production/CodingExercise   (Ignore this folder it contains .class files)
|     |
|     |--- src    (All java code)
|     |     |
|     |     |--- com/accenture ( Main project package )
|     |     |       |
|     |     |       |--- ArrayExercise.java           (Exercise 1)
|     |     |       |--- Employee.Java                (Exercise 3)
|     |     |       |--- Main.java                    (Main class to run all exercises at once)
|     |     |       |--- MethodsInJavaExercise.java   (Exercise 2)
|     |     |
|     |     |--- mybank         (Exercise 4 & 5)
|     |     |--- mycontribution (Exercise 6)
|     |     |--- myexception    (Exercise 7)
|     |
|     |
|     |--- CodingExercises.iml  (Ignore)
|     |--- .gitignore
|
|---sot-unit-testin (Exercise 8 : Complete Maven Project)
|     |
|     |--- src      (Exercise 8 : Main Java file)
|     |--- target   (Exercise 8 : Junit Test file)
|     |--- pom.xml
|
|
|---ShoppingCart  (Exercise given in POD 1) 
|   [WARNING] : Please change the filepath of "store-items.csv" and "receipt.txt" when running localhost. (Check above for details)
|   
|
|---README.txt
