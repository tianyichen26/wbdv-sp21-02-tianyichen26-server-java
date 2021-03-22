package com.example.wbdvsp2103tianyichenserverjava.services;

import com.example.wbdvsp2103tianyichenserverjava.models.Widget;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {
  private List<Widget> widgets = new ArrayList<Widget>();
  {
    Widget widget1 = new Widget(123L, "6047c76bf10b760017274b61", "HEADING", 1, "Widgets for Topic 1!");
    Widget widget2 = new Widget(234L, "ABC1", "PARAGRAPH", 1, "Lorem Ipsum 1");
    Widget widget3 = new Widget(345L, "ABC2", "HEADING", 2, "Widgets for Topic 2!");
    Widget widget4 = new Widget(456L, "ABC2", "PARAGRAPH", 1, "Lorem Ipsum 2");
    Widget widget5 = new Widget(567L, "ABC2", "PARAGRAPH", 1, "Lorem Ipsum 3");

    widgets.add(widget1);
    widgets.add(widget2);
    widgets.add(widget3);
    widgets.add(widget4);
    widgets.add(widget5);
  }

  public List<Widget> findAllWidgets() {
    return widgets;
  }

  public List<Widget> findWidgetsForTopic(String topicId) {
    List<Widget> widgetList = new ArrayList<Widget>();
    for (Widget w: widgets) {
      if(w.getTopicId().equals(topicId)) {
        widgetList.add(w);
      }
    }
    return widgetList;
  }

  public Widget createWidget(String topicId, Widget widget) {
    widget.setTopicId(topicId);
    widget.setId((new Date()).getTime());
    widgets.add(widget);
    return widget;
  }

  public Integer updateWidget (long widgetId, Widget widget) {
    for (int i=0; i<widgets.size(); i++) {
      if (widgets.get(i).getId() == widgetId) {
        widgets.set(i, widget);
        return 1;
      }
    }
    return -1;
  }

  public Integer deleteWidget (Integer widgetId) {
    int index = -1;
    for (int i=0; i<widgets.size(); i++) {
      if (widgets.get(i).getId() == widgetId) {
        index = i;
        widgets.remove(index);
        return 1;
      }
    }
    return -1;
  }


}