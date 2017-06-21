package org.dockfx;

import java.util.List;

import org.dockfx.persist.Rec;

import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.stage.Window;

/**
 * Created by jding on 14/06/2017.
 */
public class UiUtil {

  public static Node searchNode(String className, Parent root) {
    List<Node> children = root.getChildrenUnmodifiable();
    for(Node node:children){
      if(className.equals(node.getClass().getCanonicalName())){
        return node;
      }else if(node instanceof Parent){
        Node underChildren = searchNode(className, (Parent)node);
        if(underChildren!=null) return underChildren;
      }
    }
    return null;
  }

  public static Rec getRec(Node node){
    Bounds b = node.getBoundsInParent();
    Rec rec = new Rec();
    rec.setX(b.getMinX());
    rec.setY(b.getMinY());
    rec.setWidth(b.getWidth());
    rec.setHeight(b.getHeight());
    return rec;
  }
  
  public static Rec getRec(Window win){
    Rec rec = new Rec();
    rec.setX(win.getX());
    rec.setY(win.getY());
    rec.setWidth(win.getWidth());
    rec.setHeight(win.getHeight());
    return rec;
  }
}
