import java.util.HashMap;

public class Epic{

    String epicName;
    String descriptionEpic;
    String epicStatus;

    public Epic(String epicName, String descriptionEpic) {
        this.epicName = epicName;
        this.descriptionEpic = descriptionEpic;
        this.epicStatus = "NEW";
    }

    @Override
    public String toString() {
        return "Epic{" +
                "epicName='" + epicName + '\'' +
                ", descriptionEpic='" + descriptionEpic + '\'' +
                ", epicStatus='" + epicStatus + '\'' +
                '}';
    }
}

