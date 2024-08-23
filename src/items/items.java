package items;

import javax.imageio.ImageIO;

public class items {
    private items pickitem(){
        items Item = null;
        int i = new Random().nextInt(0,4);
        switch(i){
            case 0: Item = new dhumrapanDandika();break;
            case 1: Item = new beer();break;
            case 2: Item = new dagger();break;
            case 3: Item = new magnifyingLens();break;
        }

        return Item;
    }
}
