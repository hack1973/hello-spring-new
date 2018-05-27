package org.launchcode.hellospringnew.controllers;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index(HttpServletRequest request) {

        String name = request.getParameter("name");

        if (name == null || name.equals("")) {
            name = "World";
        }
        return "Hello " + name;
    }

    @RequestMapping(value ="hello", method = RequestMethod.GET)
    @ResponseBody
    public String helloForm() {

        String html = "<form method='post'>" +
                "<input type='text' name='name' />" +
                "<select name='select'> <!--Supplement an id here instead of using 'name'-->\n" +
                "<option value='english'>English</option>" +
                "<option value='spanish' selected>Spanish</option>" +
                "<option value='french'>French</option>" +
                "<option value='german'>German</option>" +
                "<option value='italian'>Italian</option>" +
                "<option value='portuguese'>Portuguese</option>" +
                "<option value='hindi'>Hindi</option>" +
                "<option value='persian'>Persian</option>" +
                "<option value='russian'>Russian</option>" +
                "<option value='japanese'>Japanese</option>" +
                "</select>" +
                "<input type='submit' value='Greet Me!' />" +
                "</form>";

        return html;
    }

    @RequestMapping(value = "hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(HttpServletRequest request) {

        String name = request.getParameter("name");
        String language = request.getParameter("select");
        String greeting;

        if (name == null || name.equals("")) {
            name = "World";
        }

        greeting = createMessage(name, language);

        return greeting;

    }

    public static String createMessage (String name, String language) {

        String hello;

        if (language.equals("english")) {
            hello = "Hello ";
        } else if (language.equals("spanish")){
            hello = "Hola ";
        } else if (language.equals("french")){
            hello = "Bonjour ";
        } else if (language.equals("german")){
            hello = "Hallo ";
        } else if (language.equals("italian")){
            hello = "Ciao ";
        } else if (language.equals("portuguese")){
            hello = "Ola ";
        } else if (language.equals("hindi")){
            hello = "Namaste ";
        } else if (language.equals("persian")){
            hello = "Salaam ";
        } else if (language.equals("russian")){
            hello = "Zdras-tvuy-te ";
        } else if (language.equals("japanese")){
            hello = "Ohayo ";
        } else {
            hello = "Hello ";
        }

        return hello + name;

    }

    @RequestMapping(value = "hello/{name}")
    @ResponseBody
    public String helloUrlSegment(@PathVariable String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "goodbye")
    public String goodbye() {
        return "redirect:/";
    }

}
