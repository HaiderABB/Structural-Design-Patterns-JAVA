import java.util.ArrayList;
import java.util.List;

interface FileComponent {
  void printFileDetail();
}

class File implements FileComponent {
  private String name;
  private String data;
  private String format;

  public File(String name, String data, String format) {
    this.name = name;
    this.data = data;
    this.format = format;
  }

  @Override
  public void printFileDetail() {
    System.out.println("File: " + name + ", Format: " + format);
  }
}

class Folder implements FileComponent {
  private String name;
  private List<FileComponent> files;

  public Folder(String name) {
    this.name = name;
    this.files = new ArrayList<>();
  }

  public void addFile(FileComponent file) {
    files.add(file);
  }

  public void removeFile(FileComponent file) {
    files.remove(file);
  }

  @Override
  public void printFileDetail() {
    System.out.println("Folder: " + name);
    for (FileComponent file : files) {
      file.printFileDetail();
    }
  }
}

public class FileManager {
  public static void main(String[] args) {
    File image = new File("haider.jpg", "Image data", "JPEG");
    File video = new File("testing.mp4", "Video data", "MP4");
    File document = new File("BookReview.docx", "Document data", "DOCX");
    File audio = new File("StayAway.mp3", "Audio data", "MP3");

    Folder folder = new Folder("Assets");
    folder.addFile(image);
    folder.addFile(video);

    Folder subFolder = new Folder("Documents");
    subFolder.addFile(document);
    folder.addFile(subFolder);
    folder.addFile(audio);

    folder.printFileDetail();
  }
}