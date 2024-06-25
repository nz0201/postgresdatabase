package cmpt276.assn2.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import cmpt276.assn2.models.Rectangle;
import cmpt276.assn2.models.RectRepo;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RectController {

    @Autowired
    private RectRepo rectRepo;

    @GetMapping("")
    public String getAllRect(Model model) {
        List<Rectangle> rectangles = rectRepo.findAll();
        model.addAttribute("rec", rectangles);
        return "rectangles/showAll";
    }

    @PostMapping("/rectangles/add")
    public String addRectangle(HttpServletRequest request) {
        String name = request.getParameter("name");
        String width = request.getParameter("width");
        String height = request.getParameter("height");
        String color = request.getParameter("color");

        String newName = (name != null && !name.isEmpty()) ? name : "defaultName";
        int newWidth = (width != null && !width.isEmpty()) ? Integer.parseInt(width) : 0;
        int newHeight = (height != null && !height.isEmpty()) ? Integer.parseInt(height) : 0;
        String newColor = (color != null && !color.isEmpty()) ? color : "#000000";

        Rectangle newRectangle = new Rectangle(newName, newWidth, newHeight, newColor);
        rectRepo.save(newRectangle);

        return "redirect:/";
    }

    @GetMapping("/rectangles/{id}")
    public String getRectangleById(@PathVariable("id") int id, Model model) {
        Optional<Rectangle> rectangle = rectRepo.findById(id);
        model.addAttribute("rectangle", rectangle.get());
        return "rectangles/view";
    }

    @GetMapping("/rectangles/delete/{id}")
    public String deleteRectangle(@PathVariable("id") int id) {
        Optional<Rectangle> rectangle = rectRepo.findById(id);
        rectRepo.delete(rectangle.get());
        return "redirect:/";
    }

    @PostMapping("/rectangles/edit/{id}")
    public String editRectangle(@PathVariable("id") int id, HttpServletRequest request) {
        Optional<Rectangle> optionalRectangle = rectRepo.findById(id);
        if (!optionalRectangle.isPresent()) {
            return "redirect:/";
        }

        Rectangle rectangle = optionalRectangle.get();

        String name = request.getParameter("name");
        String width = request.getParameter("width");
        String height = request.getParameter("height");
        String color = request.getParameter("color");

        rectangle.setName((name != null && !name.isEmpty()) ? name : rectangle.getName());
        rectangle.setWidth((width != null && !width.isEmpty()) ? Integer.parseInt(width) : rectangle.getWidth());
        rectangle.setHeight((height != null && !height.isEmpty()) ? Integer.parseInt(height) : rectangle.getHeight());
        rectangle.setColor((color != null && !color.isEmpty()) ? color : rectangle.getColor());

        rectRepo.save(rectangle);
        return "redirect:/";
    }
}
