package functionaljava;

import com.google.common.base.Splitter;

import java.util.Collection;
import java.util.Map;
import java.util.function.DoubleBinaryOperator;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class MethodReferences {
    public static final MethodReferences INSTANCE = new MethodReferences();

    private MethodReferences() {
    }

    /**
     * Create a binary operator that calculates the length of hypotenuse of a right-angled triangle
     * from the length of its legs.
     *
     * @return A binary operator that calculates the length of hypotenuse of a right-angled triangle
     * from the length of its legs.
     */
    public DoubleBinaryOperator hypotenuse() {
        // Practice writing a reference to a static method. Notice how the
        // signature of the static method matches the signature of function
        // being created.
        //
        // Replace the body of this method with one that returns a reference to
        // Math.hypot; a method that calculates the hypotenuse of a right-
        // angled triangle.
        //
        // Verify your solution:
        //     mvn test -Dtest=MethodReferencesTest#testHypotenuse
        //
        // See the solution:
        //     tutorial/method_references/static_ex1_sltn.md
        return Math::hypot;
    }

    /**
     * Create a function that creates a {@link Map} from a structured {@link String}.
     * <p>
     * Entries in the provided {@link String} are separated by {@code entrySeparator}. Within an
     * entry, the key and value are separated by {@code keyValueSeparator}. Whitespace around
     * (both entry and key-value) separators and the beginning/end of the input are ignored. Empty
     * entries (i.e., those that contain no non-whitespace characters) are also omitted from the
     * result.
     * </p>
     * <p>
     * For example: {@code ",, a = 1 ,b=2,c = 3,  ,"} contains three entries, if parsed with
     * {@code ','} as a {@code entrySeparator} and {@code '='} as a {@code keyValueSeparator} with
     * keys {@code "a"}, {@code "b"}, and {@code "c"} and values {@code "1"}, {@code "2"}, and
     * {@code "3"} (respectively).
     * </p>
     *
     * @return A function that creates a {@link Map} from a structured {@link String}.
     */
    public Function<String, Map<String, String>> mapSplitter(
            char entrySeparator,
            char keyValueSeparator) {
        // Practice writing a reference to a non-static method that is bound to
        // a particular object. Notice how the signature of the method matches
        // the signature of the function being created.
        //
        // Replace the body of this method with one that returns a reference to
        // the split method maxSplitter; a method that will parse a structured
        // string into a Map.
        //
        // Verify your solution:
        //     mvn test -Dtest=MethodReferencesTest#testMapSplitter
        //
        // See the solution:
        //     tutorial/method_references/bound_ex1_sltn.md
        Splitter.MapSplitter mapSplitter = Splitter.on(entrySeparator)
                .omitEmptyStrings()
                .trimResults()
                .withKeyValueSeparator(Splitter.on(keyValueSeparator).trimResults());
        return mapSplitter::split;
    }

    /**
     * Create a function that calculates the length of a {@link Collection}.
     *
     * @return A function that calculates the length of a {@link Collection}.
     */
    public <T> ToIntFunction<Collection<T>> collectionSizer() {
        // Practice writing a reference to a non-static method that is unbound.
        // Notice how the signature of the method does NOT match the signature
        // of the function being created. The function has an additional
        // parameter at the start that matches the class to which the function
        // belongs. This allows the object to be bound when the function is
        // invoked.
        //
        // Replace the body of this method with one that returns a reference to
        // an unbound method that calculates the size of (number of elements in)
        // a Collection.
        //
        // Since the method reference should be unbound, it must be an instance
        // method of the Collection class.
        //
        // Verify your solution:
        //     mvn test -Dtest=MethodReferencesTest#testCollectionSizer
        //
        // See the solution:
        //     tutorial/method_references/unbound_ex1_sltn.md
        return Collection::size;
    }

    /**
     * Create a function that creates a new string from an array of bytes representing the
     * characters of the string.
     *
     * @return A function that creates a new string from an array of bytes representing the
     * characters of the string.
     */
    public Function<byte[], String> stringCreator() {
        // Practice writing a reference to a constructor. Notice how the
        // parameters of the constructor match the parameters of the function
        // being created and the return type of the function being created
        // matches the class whose constructor is being referenced.
        //
        // Replace the body of this method with one that returns a reference to
        // a constructor that creates an instance of a String from the bytes
        // representing its characters.
        //
        // It's safe to assume that the input is specified in your platform's
        // default charset.
        //
        // Verify your solution:
        //     mvn test -Dtest=MethodReferencesTest#testStringCreator
        //
        // See the solution:
        //     tutorial/method_references/constructor_ex1_sltn.md
        return String::new;
    }
}
