import java.util.ArrayList;
import java.util.List;

public class ListenerPattern {
    public static void main(String[] args) {
        Button_ button = new Button_();
        button.addOnClickListener(new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("Button clicked_1...");
            }
        });

        button.addOnClickListener(new OnClickListener() {
            @Override
            public void onClick() {
                System.out.println("Button clicked_2...");
            }
        });

      //  button.clearSubscriptions();
        button.click();
    }
}
 // Like "Subject"
class Button_ {
    // callbacks -> Observers
    private List<OnClickListener> onClickListeners = new ArrayList<>();

    public void addOnClickListener(OnClickListener onClickListener) {
        this.onClickListeners.add(onClickListener);
    }

    public void removeOnClickListener(OnClickListener onClickListener) {
        this.onClickListeners.remove(onClickListener);
    }

    public void clearSubscriptions() {
        this.onClickListeners.clear();
    }

    public void click() {
        for (OnClickListener onClickListener: onClickListeners) {
            if (onClickListener != null) {
                onClickListener.onClick();
            }
        }
    }
}

interface OnClickListener {
    void onClick();
}