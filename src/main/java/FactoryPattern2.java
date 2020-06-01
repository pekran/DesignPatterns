import java.util.Arrays;
import java.util.List;

public class FactoryPattern2 {
    public static void main(String[] args) {
        WindowsElementsFactory windowsElementsFactory = new WindowsElementsFactory();
        windowsElementsFactory.drawElements();
        windowsElementsFactory.printElementNames();

        LinuxElementsFactory linuxElementsFactory = new LinuxElementsFactory();
        linuxElementsFactory.drawElements();
        linuxElementsFactory.printElementNames();
    }
}

abstract class _UiElement {
    private final String name;

    _UiElement(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void draw();
}

class WidowsUiElement extends _UiElement {
    WidowsUiElement(String name) {
        super(name);
    }

    @Override
    public void draw() {
        System.out.println("Win elem");
    }
}

class LinuxUiElement extends _UiElement {
    LinuxUiElement(String name) {
        super(name);
    }

    @Override
    public void draw() {
        System.out.println("linux elem");
    }
}

abstract class _UiElementFactoryMethod {
    public abstract List<_UiElement> createElements();

    public void drawElements() {
        List<_UiElement> elements = createElements();
        for (_UiElement element : elements) {
            element.draw();
        }
    }

    public void printElementNames() {
        List<_UiElement> elements = createElements();
        for (_UiElement element : elements) {
            System.out.println(element.getName());
        }
    }
}

class LinuxElementsFactory extends _UiElementFactoryMethod {

    @Override
    public List<_UiElement> createElements() {
        return Arrays.asList(
               new LinuxUiElement("button"),
               new LinuxUiElement("toolbar"),
               new LinuxUiElement("wifi-bar"),
               new LinuxUiElement("progressbar")
        );
    }

}

class WindowsElementsFactory extends _UiElementFactoryMethod{

    @Override
    public List<_UiElement> createElements() {
        return Arrays.asList(
                new WidowsUiElement("button"),
                new WidowsUiElement("toolbarBlue"),
                new WidowsUiElement("GamingGrafikcardGood"),
                new WidowsUiElement("wifi-bar")
        );
    }
}