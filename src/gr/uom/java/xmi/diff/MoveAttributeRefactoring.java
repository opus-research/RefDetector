package gr.uom.java.xmi.diff;

import gr.uom.java.xmi.UMLAttribute;

public class MoveAttributeRefactoring implements Refactoring {
	private static final long serialVersionUID = -6789932785315848736L;
	protected UMLAttribute movedAttribute;
	protected String sourceClassName;
	protected String targetClassName;
	
	public MoveAttributeRefactoring(UMLAttribute movedAttribute,
			String sourceClassName, String targetClassName) {
		this.movedAttribute = movedAttribute;
		this.sourceClassName = sourceClassName;
		this.targetClassName = targetClassName;
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

	public String getName() {
		return this.getRefactoringType().getDisplayName();
	}

	public RefactoringType getRefactoringType() {
		return RefactoringType.MOVE_ATTRIBUTE;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public UMLAttribute getMovedAttribute() {
		return movedAttribute;
	}

	public String getSourceClassName() {
		return sourceClassName;
	}

	public String getTargetClassName() {
		return targetClassName;
	}
	
}
