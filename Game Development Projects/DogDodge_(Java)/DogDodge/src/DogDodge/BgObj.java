package DogDodge;
/* 背景 */
import java.awt.*;

public class BgObj extends GameObj {
	public BgObj() {
		super();
	}

	public BgObj(Image img, int x, int y, double speed) {
		super(img, x, y, speed);
	}
	
	@Override
	public void paintSelf(Graphics gImage) {
		super.paintSelf(gImage);
		x -= speed;
		if (x <= -1200) {
			x = -90; //-越大圖案會越往前(左)跳
		}
	}
}

