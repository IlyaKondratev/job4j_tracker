package lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> compSize =
                (left, right) -> left.getSize() - right.getSize();
        attachments.sort(compSize);
        System.out.println(attachments);
        System.out.println();
        Comparator<Attachment> compName =
                (left, right) -> left.getName().compareTo(right.getName());
        attachments.sort(compName);
        System.out.println(attachments);
    }
}