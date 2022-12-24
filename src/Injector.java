import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {
    public <T> T inject(T object, boolean choice) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Properties properties = new Properties();
        File file = new File("C:\\Users\\Пажылой вертолет\\IdeaProjects\\lab5\\src\\SomeProperties.properties");
        properties.load(new FileReader(file));

        Class class_1;

        if (choice)
            class_1 = Class.forName(properties.getProperty("SomeImpl"));
        else
            class_1 = Class.forName(properties.getProperty("OtherImpl"));

        Class class_2 = Class.forName(properties.getProperty("SomeOtherInterface"));

        Field[] fields = object.getClass().getDeclaredFields();

        for(Field f : fields)
        {
            f.setAccessible(true);
            if(f.isAnnotationPresent(AutoInjectable.class) && f.getType() == SomeInterface.class)
                f.set(object,class_1.newInstance());
            if(f.isAnnotationPresent(AutoInjectable.class) && f.getType() == SomeOtherInterface.class)
                f.set(object,class_2.newInstance());
        }
        return object;
    }
}
