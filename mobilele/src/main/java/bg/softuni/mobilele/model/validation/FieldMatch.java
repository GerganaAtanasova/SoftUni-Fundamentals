package bg.softuni.mobilele.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //обяснява че би трябвало това нещо да бъде активно в runtime
@Target(ElementType.TYPE) //когато е TYPE извъртаме анотацията върху целия клас
@Constraint(validatedBy = FieldMatchValidator.class)
public @interface FieldMatch {

    String first();

    String second();

    String message() default "Invalid Email";

    Class<?> [] groups() default {}; // когато имаме един и същи модел който в някои случаи трябва да е валиден в други не

    Class<? extends Payload>[] payload() default {};
}
