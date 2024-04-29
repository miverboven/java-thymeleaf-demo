package fact.it.examplemvc.controller;

import fact.it.examplemvc.model.Dish;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class MainController {

    private ArrayList<Dish> storageList = new ArrayList<>();

    @PostConstruct
    private void fillData(){
        storageList.add(new Dish("Pizza calzone", 964, true));
        storageList.add(new Dish("Caesar Salad with Chicken", 260, false));
        storageList.add(new Dish("Apple Lattice Pie", 360, true));
    }

    @RequestMapping("/aboutus")
    public String aboutUs() {
        return "aboutus";
    }

    @RequestMapping("/singledish")
    public String singleDish(Model model) {

        Dish returnDish = storageList.get(0);
        model.addAttribute("dish",returnDish);

        return "dishdetails";
    }

    @RequestMapping("/dishlist")
    public String dishList(Model model) {

        model.addAttribute("dishList", storageList);

        return "dishlist";
    }

    @RequestMapping("/newdish")
    public String newDish() {
        return "newdish";
    }

    @RequestMapping("/submitnewdish")
    public String submitNewDish(HttpServletRequest request, Model model) {

        String name = request.getParameter("name");
        Integer calories = Integer.parseInt(request.getParameter("calories"));
        boolean vegetarian = (request.getParameter("vegetarian") != null);

        Dish dish = new Dish(name, calories, vegetarian);

        storageList.add(dish);

        model.addAttribute("dish",dish);

        return "dishdetails";
    }

    @RequestMapping("/dishdetails")
    public String dishDetails(HttpServletRequest request, Model model) {

        int dishIndex = Integer.parseInt(request.getParameter("dishIndex"));
        if (dishIndex < 0) {
            model.addAttribute("errormessage", "You did not select any dish!");
            return "error";
        }

        Dish returnDish = storageList.get(dishIndex);
        model.addAttribute("dish",returnDish);

        return "dishdetails";
    }

}
