## Analisar HTML
Nesse projeto é tem o objetivo de extrair o texto mais profundo e, também, verifica se o HTML está bem formado. Esse código percorre a página web HTML e, caso esteja bem formatado, ele retorna na 

### Como Usar
O pacote contém três classes principais:

- HtmlAnalyzer: A classe que contém o método main para executar o programa. Ele recebe uma URL como entrada e chama outraos métodos para extrair o texto mais profundo da página da web e verifica se o HTML está bem formado.
- TextExtractor: A classe que extrai o HTML da página da web e a transforma em uma String para realizar a tarefa e também retorna uma mensagem de erro caso tenha algum problema na conexão.
- HTMLTextExtractor: A classe que extrai o texto mais profundo HTML. Na hora de retornar, ele remove todos os elementos HTML não relevantes e retorna apenas o etxto


Para executar o programa, você pode compilar todas as classes e executar, usando os comandos abaixo:
```
javac HtmlAnalyzer.java 
java HtmlAnalyzer http://www.example.com
```
Substitua http://www.example.com pela URL da página que deseja analisar.

### Requisitos
Este projeto requer o Java 8 ou superior.

#-------------------------------------------------------------------------------#

## Analyzing HTML
The goal of this project is to extract the deepest text and also verify if the HTML is well-formed. This code traverses the HTML web page and, if it is well-formed, it returns it.

### How to Use
The package contains three main classes:

- HtmlAnalyzer: The class that contains the main method to execute the program. It receives a URL as input and calls other methods to extract the deepest text from the web page and verify if the HTML is well-formed.
- TextExtractor: The class that extracts the HTML from the web page and turns it into a String to perform the task, and also returns an error message if there is a problem with the connection.
- HTMLTextExtractor: The class that extracts the deepest HTML text. When returning, it removes all irrelevant HTML elements and returns only the text.

To execute the program, you can compile all the classes and run it using the commands below:
```
javac HtmlAnalyzer.java
java HtmlAnalyzer http://www.example.com
```
Replace http://www.example.com with the URL of the page you want to analyze.

### Requirements
This project requires Java 8 or higher.
