package am.users.chat.servlets.util.validator;

import org.apache.commons.fileupload.FileItem;

import java.util.List;

public class RequestValidator<T> {
  private T value;
  List<FileItem> fileItems;
  private boolean hasError;

  public T getValue() {
    return value;
  }

  public void setValue(T value) {
    this.value = value;
  }

  public boolean isHasError() {
    return hasError;
  }

  public void setHasError(boolean hasError) {
    this.hasError = hasError;
  }

  public List<FileItem> getFileItems() {
    return fileItems;
  }

  public void setFileItems(List<FileItem> fileItems) {
    this.fileItems = fileItems;
  }
}
