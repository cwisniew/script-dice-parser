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
package net.rptools.mtscript.util;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.rptools.mtscript.ast.ASTAttributeKey;
import net.rptools.mtscript.ast.ASTNode;

/** Class for printing out th details of a tree of {@link ASTNode}s. */
public class ASTPrinter {

  /**
   * Prints out the tree of {@link ASTNode}s with root of {@code node}.
   *
   * @param node the root of the tree.
   * @param indentLevel the level of indentation for the output.
   */
  public void print(ASTNode node, int indentLevel) {
    String indent = " ".repeat(indentLevel);
    System.out.println(indent + node.getType() + ":");
    Optional<String> valueAttr = node.getAttribute(ASTAttributeKey.VALUE, String.class);
    valueAttr.ifPresent(value -> System.out.println(formatValue(value, indentLevel)));

    node.getChildren().forEach(n -> print(n, indentLevel + 2));
  }

  private String formatValue(String value, int indentLevel) {
    String indent = " ".repeat(indentLevel);
    Pattern pattern = Pattern.compile("^", Pattern.MULTILINE);
    Matcher matcher = pattern.matcher(value);
    return matcher.replaceAll(indent + "|");
  }
}
