package it.lorenzo.StopAndCode2.exception;

public class LibroNotFoundException extends RuntimeException {
  public LibroNotFoundException(String message) {
    super(message);
  }
}
