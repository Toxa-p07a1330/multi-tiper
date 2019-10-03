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

      boolean isMirroring = false;
      Button button = new Button("enMirroring", Model.of("Disable mirroring?"));


      button.setOutputMarkupId(true);
      button.add(new AjaxEventBehavior("click") {
          @Override
          protected void onEvent(AjaxRequestTarget ajaxRequestTarget) {
              if (getComponent().getDefaultModelObjectAsString().equals("Enable mirroring?"))
                  getComponent().setDefaultModelObject("Disable mirroring?");
              else
                  getComponent().setDefaultModelObject("Enable mirroring?");
              ajaxRequestTarget.add(getComponent());
          }
      });
      TextArea passive = new TextArea("passiveArea", Model.of(""));
      TextArea active = new TextArea("activeArea", Model.of(""));
      active.add(new AjaxEventBehavior("keypress") {
          @Override
          protected void onEvent(AjaxRequestTarget ajaxRequestTarget) {
           if (button.getDefaultModelObjectAsString().equals("Disable mirroring?"))
           {    passive.setDefaultModelObject(active.getInput());
                ajaxRequestTarget.add(passive);

           }
          }
      });

      Link saver = new Link<Void>("saver"){
          @Override
          public void onClick() {
              File saveTo = new File("C:\\Users\\User\\Desktop\\Sandbox\\"+ new Date().getTime()+".txt");       //ввести путь к стораджу
              try {
                  FileWriter fw = new FileWriter(saveTo);
                  fw.close();
              }
              catch (Exception e)
              {
                    System.out.println(e.getMessage());
                  System.out.println("err");
              }
          }

      };

      passive.setOutputMarkupId(true);

      add(passive);
      add(active);
      add(button);
      add(saver);
  }
}

