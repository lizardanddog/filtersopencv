
public class Filters{

public static void grayScale(Bitmap bitmapSource, Bitmap bitmapResult){
        Mat sourceMat = new Mat(); // This is the Matrix of the source Image
        Utils.bitmapToMat(bitmapSource,sourceMat);
        Mat resultMat = new Mat(); // This is the Matrix of the grayScale Image
        Imgproc.cvtColor(resultMat,sourceMat,Imgproc.COLOR_RGBA2GRAY);
        Utils.matToBitmap(resultMat,bitmapResult);
    }

  
}
