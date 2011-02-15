package imf.core.dto.web.response;

import imf.core.dto.web.response.tree.BaseTreeNode;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * User: Andrey Popov
 * Date: 05.02.11
 * Time: 0:00
 */

//Обзавем класс деревом...
@XmlRootElement(name = "tree")
public class TreeResponse extends BaseResponse {

    @Override
    //Поместим элементы коллекции dtos в элемент nodes...
    @XmlElementWrapper(name = "nodes")
    //Отобразим элементы коллекции dtos под мненем "node"..., а тип данных коллекции dto - BaseTreeNode...
    //Элемент type нужен для того, чтобы избавиться от ненужных нейспеймов для отображения generic классов...
    @XmlElement(name = "node", type = BaseTreeNode.class)
    public List getDtos() {
        return super.getDtos();
    }
}
