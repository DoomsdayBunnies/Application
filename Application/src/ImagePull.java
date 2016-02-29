//package src;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;


public class ImagePull
{
	public static void main(String[] args) throws Exception
	{
		final long timeInterval=10000;
		Runnable runnable=new Runnable()
		{
			public void run()
			{
				int i=0;
				boolean check;

				while (true)
				{
					String imageUrl="http://construction1.db.erau.edu/jpg/1/image.jpg";

					if (i>10) i=0;

					do
					{
						i++;
						check=new File("image" + i + ".jpg").exists();

					}while (check==true);

					String destinationFile="image" + i + ".jpg";

					try {saveImage(imageUrl, destinationFile);}

					catch (IOException e1)
					{
						System.out.println("Something went wrong with the file I/O!");
						e1.printStackTrace();
					}

					try
					{Thread.sleep(timeInterval);}
					catch (InterruptedException e) {e.printStackTrace();}
				}
			}
		};

		Thread thread = new Thread(runnable);
		thread.start();
	}

	public static void saveImage(String imageUrl, String destinationFile) throws IOException
	{
		URL url=new URL(imageUrl);
		InputStream is=url.openStream();
		OutputStream os=new FileOutputStream(destinationFile);

		byte[] b=new byte[2048];
		int length;

		while ((length=is.read(b))!=-1) os.write(b, 0, length);

		is.close();
		os.close();
	}
}