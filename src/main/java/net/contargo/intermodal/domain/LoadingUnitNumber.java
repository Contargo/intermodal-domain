package net.contargo.intermodal.domain;

import java.util.Optional;


/**
 * @author  Isabell Dürlich - duerlich@synyx.de
 */
final class LoadingUnitNumber {

    private static final int BIC_LENGTH = 11;
    private static final int ILU_LENGTH = 11;
    private static final int BIC_OWNER_CODE_END_INDEX = 3;
    private static final int ILU_OWNER_CODE_END_INDEX = 4;
    private static final int BIC_EQUIPMENT_CATEGORY_END_INDEX = 3;
    private static final int BIC_SERIAL_NUMBER_END_INDEX = 10;
    private static final int ILU_SERIAL_NUMBER_END_INDEX = 10;

    /**
     * Checks if number is valid ISO 6364 BIC (four letters followed by 7 digits).
     *
     * @return  true if number is valid BIC
     */
    static boolean isValidBIC(String value) {

        if (value.length() == BIC_LENGTH) {
            boolean validOwnerCode = match(Optional.of(value.substring(0, BIC_OWNER_CODE_END_INDEX)), "[A-Z]{3}");

            boolean validEquipmentCategory = match(Optional.of(value.charAt(BIC_EQUIPMENT_CATEGORY_END_INDEX)),
                    "(U|J|Z){1}");

            boolean validSerialNumber = match(Optional.of(
                        value.substring(BIC_EQUIPMENT_CATEGORY_END_INDEX + 1, BIC_SERIAL_NUMBER_END_INDEX)),
                    "[0-9]{6}");

            boolean validCheckDigit = match(Optional.of(value.charAt(BIC_SERIAL_NUMBER_END_INDEX)), "[0-9]{1}");

            return validOwnerCode && validEquipmentCategory && validSerialNumber && validCheckDigit;
        }

        return false;
    }


    static boolean isValidILU(String value) {

        if (value.length() == ILU_LENGTH) {
            boolean validOwnerCode = match(Optional.of(value.substring(0, ILU_OWNER_CODE_END_INDEX)), "[A-Z]{4}");

            boolean validSerialNumber = match(Optional.of(
                        value.substring(ILU_OWNER_CODE_END_INDEX, ILU_SERIAL_NUMBER_END_INDEX)), "[0-9]{6}");

            boolean validCheckDigit = match(Optional.of(value.charAt(ILU_SERIAL_NUMBER_END_INDEX)), "[0-9]{1}");

            return validOwnerCode && validSerialNumber && validCheckDigit;
        }

        return false;
    }


    static boolean isSOC(String value) {

        if (value.length() == BIC_LENGTH) {
            boolean validOwnerCode = match(Optional.of(value.substring(0, BIC_OWNER_CODE_END_INDEX)), "[XXX|NON]{3}");

            boolean validEquipmentCategory = match(Optional.of(value.charAt(BIC_EQUIPMENT_CATEGORY_END_INDEX)),
                    "(U|J|Z){1}");

            boolean validSerialNumber = match(Optional.of(
                        value.substring(BIC_EQUIPMENT_CATEGORY_END_INDEX + 1, BIC_SERIAL_NUMBER_END_INDEX)),
                    "[0-9]{6}");

            boolean validCheckDigit = match(Optional.of(value.charAt(BIC_SERIAL_NUMBER_END_INDEX)), "[0-9]{1}");

            return validOwnerCode && validEquipmentCategory && validSerialNumber && validCheckDigit;
        }

        return false;
    }


    private static boolean match(Optional<?> optional, String regex) {

        return optional.isPresent() && String.valueOf(optional.get()).matches(regex);
    }
}
