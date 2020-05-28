/*
 * This software Copyright by the RPTools.net development team, and
 * licensed under the Affero GPL Version 3 or, at your option, any later
 * version.
 *
 * RPTools Source Code is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty
 * of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * You should have received a copy of the GNU Affero General Public
 * License * along with this source Code.  If not, please visit
 * <http://www.gnu.org/licenses/> and specifically the Affero license
 * text at <http://www.gnu.org/licenses/agpl.html>.
 */
package net.rptools.mtscript.script;

/**
 * Enumeration for the different export scopes for scripts.
 */
public enum ExportScope {
  /** Exported only within the same module. */
  INTERNAL("internal"),
  /** Exported to all modules. */
  EXTERNAL("external"),
  /** Exported to chat for any user. */
  CHAT_ANY("chat"),
  /** Exported to chat for trusted use only. */
  CHAT_TRUSTED("chat(trusted)"),
  /** Exported to chat for GM only. */
  CHAT_GM("chat(gm)");

  /** The label for the scope. */
  private final String label;

  /**
   * Creates a new {@code ExportScope}.
   * @param label the label for the scope.
   */
  ExportScope(String label) {
    this.label = label;
  }

  /**
   * Returns the {@code ExportScope} for a given scope label.
   *
   * @param label the label of the {@code ExportScope}.
   * @return the {@code ExportScope} for a given scope label.
   */
  public static ExportScope forLabel(String label) {
    for (ExportScope scope : ExportScope.values()) {
      if (scope.label.equals(label)) {
        return scope;
      }
    }
    throw new IllegalStateException("Unknown Scope");
  }
}
