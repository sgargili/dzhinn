package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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

    @RequestMapping(value = "/getShopById.html", method = RequestMethod.POST)
    @ResponseBody
    public Shop getShop() {
        Shop shop = new Shop();
        shop.setShopId(2);
        shop.setShopName("www.nix.ru");
        return shop;
    }

@RequestMapping(value = "/getShop.html", method = RequestMethod.GET)
    @ResponseBody
    public String getShop(@RequestBody String id) {
        Shop shop = new Shop();
        shop.setShopId(1);
        shop.setShopName("www.nix.ru");
        return shop.getShopName() + shop.getShopId();
    }


}
