package org.dockfx.persist;

import java.util.ArrayList;
import java.util.List;

import org.dockfx.UiUtil;
import org.dockfx.dock.DockPos;
import org.dockfx.pane.ContentSplitPane;

import javafx.geometry.Orientation;
import javafx.scene.Node;

/**
 * Created by jding on 14/06/2017.
 */
public class PersistableSplitPane implements Persistable<ContentSplitPane> {

  double[] spliterPostion; //for splitPane
  Orientation orientation; //for split pane
  Rec position;
  List<Persistable<?>> children = new ArrayList<>(10);

  @Override
  public ContentSplitPane reconstruct() {
    ContentSplitPane splitPane = new ContentSplitPane();
    splitPane.setOrientation(orientation);
    for(Persistable<?> child : children){
      Node childNode = (Node)child.reconstruct();
      splitPane.addNode(null,null,childNode, (orientation.equals(Orientation.HORIZONTAL) ? DockPos.LEFT : DockPos.BOTTOM));
    }

    for(int i = 0;i<spliterPostion.length; i++){
      splitPane.setDividerPosition(i,spliterPostion[i]);
    }
    return splitPane;
  }

  @Override
  public void persist(ContentSplitPane splitPane) {
    orientation = splitPane.getOrientation();
    spliterPostion = splitPane.getDividerPositions();
    position = UiUtil.getRec(splitPane);
  }

  public double[] getSpliterPostion() {
    return spliterPostion;
  }

  public void setSpliterPostion(double[] spliterPostion) {
    this.spliterPostion = spliterPostion;
  }
  public Orientation getOrientation() {
    return orientation;
  }

  public void setOrientation(Orientation orientation) {
    this.orientation = orientation;
  }

  public Rec getPosition() {
    return position;
  }

  public void setPosition(Rec position) {
    this.position = position;
  }

  public List<Persistable<?>> getChildren() {
    return children;
  }

  public void setChildren(List<Persistable<?>> children) {
    this.children = children;
  }

  public void addChild(Persistable<?> child) {
    children.add(child);
  }
}
