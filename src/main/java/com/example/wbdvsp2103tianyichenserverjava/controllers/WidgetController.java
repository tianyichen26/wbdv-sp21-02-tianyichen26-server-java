package com.example.wbdvsp2103tianyichenserverjava.controllers;
import com.example.wbdvsp2103tianyichenserverjava.models.Widget;
import com.example.wbdvsp2103tianyichenserverjava.services.WidgetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")

public class WidgetController {
  @Autowired
  WidgetService service;

  @GetMapping("/api/widgets")
  public List<Widget> findAllWidgets() {
    return service.findAllWidgets();
  }

  @GetMapping("/api/topics/{topicId}/widgets")
  public List<Widget> findWidgetsForTopic(
      @PathVariable("topicId") String topicId) {
    return service.findWidgetsForTopic(topicId);
  }

  @PostMapping("/api/topics/{topicId}/widgets")
  public  Widget createWidgetForTopic(
      @PathVariable("topicId") String topicId,
      @RequestBody Widget widget
  ) {
    return service.createWidget(topicId, widget);
  }

  @PutMapping("/api/widgets/{wid}")
  public Integer updateWidget(
      @PathVariable("wid") long widgetId,
      @RequestBody Widget widget
  ) {
    return service.updateWidget(widgetId, widget);
  }


  @DeleteMapping("/api/widgets/{widgetId}")
  public Integer deleteWidget(
      @PathVariable("widgetId") Integer widgetId
  ) {
    return service.deleteWidget(widgetId);
  }

}
