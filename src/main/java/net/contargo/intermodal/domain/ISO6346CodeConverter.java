package net.contargo.intermodal.domain;

import java.util.Optional;


/**
 * Gets size of a {@link Container} from its ISO 6346 size code.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class ISO6346CodeConverter {

    public static Optional<Double> getLengthFromSizeType(String sizeType) {

        if (sizeType.length() == 4) {
            Optional<ISO6346LengthCode> lengthCode = ISO6346LengthCode.getByCharacter(sizeType.charAt(0));

            return lengthCode.map(ISO6346LengthCode::getLengthInFoot);
        }

        return Optional.empty();
    }


    public static Optional<String> getTypeDesignationFromSizeType(String sizeType) {

        if (sizeType.length() == 4) {
            Optional<ISO6346ContainerType> containerType = ISO6346ContainerType.getByType(sizeType.substring(2, 4));

            return containerType.map(ISO6346ContainerType::getTypeDesignation);
        }

        return Optional.empty();
    }
}
