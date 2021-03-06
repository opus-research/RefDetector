package gr.uom.java.xmi.diff;

import gr.uom.java.xmi.UMLAttribute;

public class PushDownAttributeRefactoring extends MoveAttributeRefactoring {

	private static final long serialVersionUID = -479906492154055887L;

	public PushDownAttributeRefactoring(UMLAttribute movedAttribute,
			String sourceClassName, String targetClassName) {
		super(movedAttribute, sourceClassName, targetClassName);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName()).append("\t");
		sb.append(movedAttribute);
		sb.append(" from class ");
		sb.append(sourceClassName);
		sb.append(" to class ");
		sb.append(targetClassName);
		return sb.toString();
	}

	public RefactoringType getRefactoringType() {
		return RefactoringType.PUSH_DOWN_ATTRIBUTE;
	}
}
