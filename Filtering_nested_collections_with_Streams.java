public class Author {
  private final String name;
  private final List<Book> books;
  ...
}
public class Book {
    
  private final String title;
  private final LocalDate published;
  ...
}

List<Book> book2002fm = authors.stream()
  .flatMap(author -> author.getBooks().stream())
  .filter(book -> book.getPublished().getYear() == 2002)
  .collect(Collectors.toList());

List<Book> book2002mm = authors.stream()
  .<Book>mapMulti((author, consumer) -> {
     for (Book book : author.getBooks()) {
       if (book.getPublished().getYear() == 2002) {
         consumer.accept(book);
       }
     }
   })
   .collect(Collectors.toList());

List<Author> author2002mm = authors.stream()
  .<Author>mapMulti((author, consumer) -> {
     for (Book book : author.getBooks()) {
       if (book.getPublished().getYear() == 2002) {
         consumer.accept(author);
         break;
       }
     }
   })
   .collect(Collectors.toList());

List<Author> authors2002am = authors.stream()
  .filter(
     author -> author.getBooks()
                     .stream()
                     .anyMatch(book -> book.getPublished()
                       .getYear() == 2002)
  )
 .collect(Collectors.toList());