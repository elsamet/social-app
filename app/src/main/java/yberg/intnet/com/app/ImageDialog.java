package yberg.intnet.com.app;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by Viktor on 2016-03-31.
 *
 * A dialog for displaying larger popup images from posts and comments.
 */
public class ImageDialog extends DialogFragment {

    private ImageView image, closeButton;
    private View view;

    public ImageDialog() {
        // Empty constructor required for DialogFragment
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param bitmap The image to display.
     * @return A new instance of fragment PostDialog.
     */
    public static ImageDialog newInstance(Bitmap bitmap) {
        ImageDialog fragment = new ImageDialog();
        Bundle args = new Bundle();
        args.putParcelable("bitmap", bitmap);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_image_dialog, container, false);

        image = (ImageView) view.findViewById(R.id.image);
        Bitmap bitmap = getArguments().getParcelable("bitmap");
        image.setImageBitmap(bitmap);

        closeButton = (ImageView) view.findViewById(R.id.closeButton);
        closeButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dismiss();
                    }
                }
        );

        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);

        return view;
    }

    @Override
    public void onResume() {
        // Get existing layout params for the window
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        // Assign window properties to fill the parent
        params.width = WindowManager.LayoutParams.WRAP_CONTENT;
        params.height = WindowManager.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
        // Call super onResume after sizing
        super.onResume();
    }

}
