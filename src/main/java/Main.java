import controller.TextController;
import model.Text;
import util.IData;

public class Main {
    public static void main(String[] args) {
        Text text = new Text(IData.text);
        TextController textController = new TextController(text);
        textController.getSentencesWithRepeatedWords();
    }

}
