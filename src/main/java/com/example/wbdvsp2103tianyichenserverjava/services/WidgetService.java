package com.example.wbdvsp2103tianyichenserverjava.services;

import com.example.wbdvsp2103tianyichenserverjava.models.Widget;
import com.example.wbdvsp2103tianyichenserverjava.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WidgetService {

    @Autowired
    WidgetRepository repository;


  public List<Widget> findAllWidgets() {
    return (List<Widget>) repository.findAll();
  }

  public List<Widget> findWidgetsForTopic(String topicId) {
    return repository.findWidgetsForTopic(topicId);
  }

  public Widget createWidget(String topicId, Widget widget) {
    widget.setTopicId(topicId);
    return repository.save(widget);
  }

  public Integer updateWidget(Long id, Widget widget) {
    if(repository.findById(id).isPresent()) {
      Widget originalWidget = repository.findById(id).get();

      originalWidget.setText(widget.getText());
      originalWidget.setTopicId(widget.getTopicId());
      originalWidget.setId(widget.getId());
      originalWidget.setSize(widget.getSize());
      originalWidget.setType(widget.getType());
      originalWidget.setSrc(widget.getSrc());
      originalWidget.setWidth(widget.getWidth());
      originalWidget.setHeight(widget.getHeight());

      repository.save(originalWidget);
      return 1;
    }
    return 0;
  }

  public Integer deleteWidget (Long widgetId) {
    repository.deleteById(widgetId);
    return -1;
  }
  public Widget findWidgetById(Long id) {
    if(repository.findById(id).isPresent()) {
      return repository.findById(id).get();
    }
    return null;
  }

}