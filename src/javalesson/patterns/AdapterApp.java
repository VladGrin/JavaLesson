package javalesson.patterns;

public class AdapterApp {
    public static void main(String[] args) {
        VectorGraphics vectorGraphics = new VectorAdapterFromRaster();
        vectorGraphics.drawLine();
        vectorGraphics.drawSquare();

        VectorGraphics vectorGraphics2 = new VectorAdapterFromRaster2(new RasterGraphic());
        vectorGraphics2.drawLine();
        vectorGraphics2.drawSquare();
    }
}
interface VectorGraphics{
    void drawLine();
    void drawSquare();
}
class RasterGraphic{
    void drawRasterLine(){
        System.out.println("Draw line");
    }
    void drawRasterSquare(){
        System.out.println("Draw square");
    }
}
class VectorAdapterFromRaster extends RasterGraphic implements VectorGraphics{

    @Override
    public void drawLine() {
        drawRasterLine();
    }

    @Override
    public void drawSquare() {
        drawRasterSquare();
    }
}
class VectorAdapterFromRaster2 implements VectorGraphics{
    RasterGraphic rasterGraphic;

    public VectorAdapterFromRaster2(RasterGraphic rasterGraphic) {
        this.rasterGraphic = rasterGraphic;
    }

    @Override
    public void drawLine() {
        rasterGraphic.drawRasterLine();
    }

    @Override
    public void drawSquare() {
        rasterGraphic.drawRasterSquare();
    }
}