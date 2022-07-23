package app.raiko.exception;

public class NotFoundAdminException extends RuntimeException{

  public NotFoundAdminException(String message) {
      super(message);
  }
}
