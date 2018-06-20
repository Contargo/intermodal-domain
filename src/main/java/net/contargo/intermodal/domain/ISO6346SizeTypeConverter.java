package net.contargo.intermodal.domain;

import java.util.Optional;


/**
 * Gets type designation and size of a {@link Container} from its ISO 6346 size code.
 *
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
public class ISO6346SizeTypeConverter {

    /**
     * Returns the length of a {@link Container} as indicated by the first character of its sizeType.
     *
     * @param  sizeType
     *
     * @return  Optional of length in foot if code is valid
     */
    public static Optional<Double> getLengthFromSizeType(String sizeType) {

        Optional<ISO6346LengthCode> lengthCode = ISO6346LengthCode.getByCharacter(String.valueOf(sizeType.charAt(0)));

        if (!lengthCode.isPresent()) {
            throw new IllegalArgumentException(String.format(
                    "Invalid container size type \'%s\': Unknown length code \'%s\'.", sizeType, sizeType.charAt(0)));
        }

        return lengthCode.map(ISO6346LengthCode::getLengthInFoot);
    }


    /**
     * Returns the type designation of a {@link Container} as indicated by the third and fourth character of its
     * sizeType.
     *
     * @param  sizeType
     *
     * @return  Optional of type designation if code is valid
     */
    public static Optional<String> getTypeDesignationFromSizeType(String sizeType) {

        Optional<ISO6346ContainerType> containerType = ISO6346ContainerType.getByType(sizeType.substring(2, 4));

        if (!containerType.isPresent()) {
            throw new IllegalArgumentException(String.format(
                    "Invalid container size type \'%s\': Unknown container type code \'%s\'.", sizeType,
                    sizeType.substring(2, 4)));
        }

        return containerType.map(ISO6346ContainerType::getTypeDesignation);
    }
}
