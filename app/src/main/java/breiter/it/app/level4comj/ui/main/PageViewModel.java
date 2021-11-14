package breiter.it.app.level4comj.ui.main;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

public class PageViewModel extends ViewModel {

    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    /**
     * Name protocol based on input and return String for UI.
     */
    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            String protocolName = "";
            if (input == 1) {
                protocolName = "TCP";
            } else if (input == 2) {
                protocolName =  "UDP";
            }
            return "Here you can start a " + protocolName + " client or server.";
        }
    });

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }
}