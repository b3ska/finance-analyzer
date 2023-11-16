- Finance analyzer
- This console app can record your expenses and incomes and show you statistics about them
  - jdbc driver and slf4j api are used to create and connect to database
  - I had troubles with installation of jdbc and slf4j and the declaration of classpaths
    It would be great to add the feature of deleting records and showing them by month and category.
- No need to download anything additional; visit https://github.com/xerial/sqlite-jdbc for information
  about driver and API. You need to add them to development environment (I did it via Visual Studio Code UI).
  Also, change path to where you want the database to be created (db/DbOperations line-8) (delete url if wherever from you are running the program)
- Run the main file (FinantialAnalyzer.java)
Include Credits
