public class FactoryPattern1 {
    public static void main(String[] args) {
        UiFactory uiFactory = new UiFactory();
        UiElement button = uiFactory.getUiElement("button");
        UiElement textarea = uiFactory.getUiElement("TEXTAREA");
        button.draw();
        textarea.draw();
    }
}

interface UiElement {
    void draw();
}

class Button implements UiElement{

    @Override
    public void draw() {
        System.out.println("Im a button");
    }
}

class TextArea implements UiElement{

    @Override
    public void draw() {
        System.out.println("Im texArea");
    }
}

class UiFactory {

    public UiElement getUiElement(String uiElement) {
        if (uiElement.equalsIgnoreCase("button")) {
            return new Button();
        }
        if (uiElement.equalsIgnoreCase("TextArea")) {
            return new TextArea();
        }
        return null;
    }

}
