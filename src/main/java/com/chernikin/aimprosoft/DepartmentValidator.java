package com.chernikin.aimprosoft;

import com.chernikin.aimprosoft.domain.Department;

public class DepartmentValidator implements Validator<Department> {

    public static final int DEP_NAME_MAX_LENGTH = 50;
    public static final int DEP_COMMENT_MAX_LENGHT = 1000;

    @Override
    public ValidationResult validate(Department department) {
        final ValidationResult validationResult = new ValidationResult();

        if (!isDepartmentNameValid(department)) {
            validationResult.addErrorMessage("Department name is not valid");
        }
        if (!isCommentValid(department)) {
            validationResult.addErrorMessage("Comment is not valid");
        }
        return validationResult;
    }

    private boolean isDepartmentNameValid(Department department) {
        final String departmentName = department.getDepartmentName();
        return departmentName != null && !departmentName.isEmpty()
                && departmentName.length() <= DEP_NAME_MAX_LENGTH;
    }

    private boolean isCommentValid(Department department) {
        return department.getComments().length() <= DEP_COMMENT_MAX_LENGHT;
    }
}
