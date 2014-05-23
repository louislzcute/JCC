package jcc.preferences;

import jcc.Activator;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.preference.FileFieldEditor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class PreferencesPageHandler extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage {

	private FileFieldEditor rulesFile;
	private BooleanFieldEditor loadRulesInCheck;

	public PreferencesPageHandler() {
		super(GRID);
		setPreferenceStore(Activator.getDefault().getPreferenceStore());
		setDescription("This page contains preferences for JCC");
	}

	public void init(IWorkbench workbench) {
		Activator.getDefault().getPreferenceStore();

	}

	@Override
	protected void createFieldEditors() {
		// TODO Auto-generated method stub
		rulesFile = new FileFieldEditor(PreferenceConstants.P_RULES_FILE,
				"Rules file", true, getFieldEditorParent());
		addField(rulesFile);

		loadRulesInCheck = new BooleanFieldEditor(
				PreferenceConstants.P_RELOAD_RULES_WHEN_CHECK,
				"Reload rules when check", getFieldEditorParent());

		addField(loadRulesInCheck);

	}

	@Override
	public boolean performOk() {
		return super.performOk();
	}

	public static String getRulesFile() {
		return Activator.getDefault().getPreferenceStore()
				.getString(PreferenceConstants.P_RULES_FILE);
	}

	public static boolean reloadRulesWhenCheck() {
		return Activator.getDefault().getPreferenceStore()
				.getBoolean(PreferenceConstants.P_RELOAD_RULES_WHEN_CHECK);
	}
}