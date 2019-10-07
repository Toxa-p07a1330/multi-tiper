package ru.bmstu.iu3;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.link.Link;
import org.apache.wicket.model.Model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStream;
import java.util.Date;
import java.util.EventListener;


public class HomePage extends WebPage {
  public HomePage()
  {
        TextArea textArea = new TextArea("textArea");
        add(textArea);
        Link link = new Link<Void>("link") {
            @Override
            public void onClick() {
                System.out.println(textArea.getInput());
            }
        };
        add(link);

  }
}

