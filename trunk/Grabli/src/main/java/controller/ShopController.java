package controller;

import factories.FactoryDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pojo.Shop;

/**
 * Created by IntelliJ IDEA.
 * User: Andrey Popov
 * Date: 08.11.2010
 * Time: 17:16:46
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ShopController {
    private FactoryDao fd = FactoryDao.getInstance();

    @RequestMapping(value = "/getShopById.html", headers="Accept=*/*", method = RequestMethod.POST)
    @ResponseBody
    public Shop getShop(@RequestParam("id") int id) {
        System.out.println("sdaklfjaskl;djfkl;asdjfkl;asdj -> " + id);
        return fd.getShopDao().getShopById(id);
    }

    @RequestMapping(value = "/getShop.html", method = RequestMethod.GET)
    @ResponseBody
    public String getShopNameById(@RequestParam("id") int id) {
        return fd.getShopDao().getShopById(id).getShopName();
    }


}
