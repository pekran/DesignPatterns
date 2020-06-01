import java.util.ArrayList;
import java.util.List;

public class ListenerPattern2 {
    public static void main(String[] args) {
        Button2 button2 = new Button2();
        button2.onClickListener2s.add(new OnClickListener2() {
            @Override
            public void onClick() {
                System.out.println("one");
            }
        });

        button2.onClickListener2s.add(new OnClickListener2() {
            @Override
            public void onClick() {
                System.out.println("two");
            }
        });

        button2.click();
    }

}


class Button2 {
    List<OnClickListener2> onClickListener2s = new ArrayList<>();

    public void click() {
        for (OnClickListener2 onClickListener2 : onClickListener2s) {
            onClickListener2.onClick();
        }
    }

}


interface OnClickListener2 {
    void onClick();
}