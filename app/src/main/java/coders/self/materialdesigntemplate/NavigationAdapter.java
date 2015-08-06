package coders.self.materialdesigntemplate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Carlos Bedoy on 8/6/15.
 * <p/>
 * Mobile App Developer - MaterialDesignTemplate
 * <p/>
 * Pademobile
 */
public class NavigationAdapter extends AbstractAdapter<NavigationItem> {


    public NavigationAdapter(Context context, LayoutInflater layoutInflater, List<NavigationItem> dataModel) {
        super(context, layoutInflater, dataModel);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        int KIND = getItemViewType(i);
        if (KIND == 0) {

            CellViewHolder cellViewHolder;

            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.cell_view, viewGroup, false);

                cellViewHolder = new CellViewHolder();
                cellViewHolder.iconCell = (ImageView) view.findViewById(R.id.rowIcon);
                cellViewHolder.textCell = (TextView) view.findViewById(R.id.rowText);

                view.setTag(cellViewHolder);
            } else {
                cellViewHolder = (CellViewHolder) view.getTag();
            }

            NavigationItem navigationItem = getDataModel().get(i);

            cellViewHolder.textCell.setText(navigationItem.getCellText());
            cellViewHolder.iconCell.setImageResource(navigationItem.getCellImage());

            return view;
        } else {

            TopViewHolder topViewHolder;
            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.header_view, viewGroup, false);

                topViewHolder = new TopViewHolder();
                topViewHolder.avatarView = (ImageView) view.findViewById(R.id.avatar);
                topViewHolder.backgroundView = (ImageView) view.findViewById(R.id.background);
                topViewHolder.emailView = (TextView) view.findViewById(R.id.email);
                topViewHolder.nameView = (TextView) view.findViewById(R.id.name);

                view.setTag(topViewHolder);
            } else {
                topViewHolder = (TopViewHolder) view.getTag();
            }

            NavigationItem navigationItem = getDataModel().get(i);
            topViewHolder.nameView.setText(navigationItem.getUserName());
            topViewHolder.emailView.setText(navigationItem.getEmail());
            topViewHolder.backgroundView.setImageResource(navigationItem.getImageResource());
            topViewHolder.avatarView.setImageResource(navigationItem.getAvatarResource());

            return view;
        }
    }

    @Override
    public int getItemViewType(int position) {
        NavigationItem navigationItem = getDataModel().get(position);
        if (navigationItem.getKindOfElement() == NavigationItem.KindOfElement.CELL) {
            return 0;
        } else {
            return 1;
        }
    }

    private class TopViewHolder {
        ImageView backgroundView;
        TextView emailView;
        TextView nameView;
        ImageView avatarView;

    }

    private class CellViewHolder {
        ImageView iconCell;
        TextView textCell;
    }
}
