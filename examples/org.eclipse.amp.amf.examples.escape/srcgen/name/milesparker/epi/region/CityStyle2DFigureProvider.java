package name.milesparker.epi.region;

import org.ascape.util.vis.ColorFeature;
import org.ascape.model.CellOccupant;
import org.ascape.model.HostCell;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.ColorConstants;

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.amp.agf.gef.IFigureProvider;
import org.eclipse.amp.agf.gef.DefaultFigureProvider;
import org.eclipse.amp.agf.gef.Shapes;

/**
 * <!-- begin-user-doc -->
 * City Style 2D Java Implementation.
 * 
 * Generated by AMF for model: EpidemicRegional.metaabm in project: org.eclipse.amp.amf.examples.escape 
 * <!-- end-user-doc -->
 * @generated
 */
public class CityStyle2DFigureProvider extends DefaultFigureProvider {

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static IFigureProvider singleton;

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IFigure getFigure(Object object) {
		IFigure figure = null;
		Color color = null;
		City rootActGroup = (City) object;
		City cityRule = rootActGroup;
		if (cityRule.getCommunityInfectionStatus() == CommunityInfectionStatusEnum.infectionsObserved) {
			if (figure == null) {
				figure = Shapes.createOval();
			}
			color = ColorConstants.yellow;

			figure.setBackgroundColor(color);
			((Shape) figure).setFill(true);
		}
		if (!(cityRule.getCommunityInfectionStatus() == CommunityInfectionStatusEnum.infectionsObserved)) {
			if (figure == null) {
				figure = Shapes.createOval();
			}
			color = ColorConstants.blue;

			figure.setBackgroundColor(color);
			((Shape) figure).setFill(true);
		}
		if (cityRule.getCommunityInfectionStatus() == CommunityInfectionStatusEnum.originCity) {
			if (figure == null) {
				figure = Shapes.createOval();
			}
			color = ColorConstants.gray;

			figure.setBackgroundColor(color);
			((Shape) figure).setFill(true);
		}
		return figure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static IFigureProvider getDefault() {
		if (singleton == null) {
			singleton = new CityStyle2DFigureProvider();
		}
		return singleton;
	}
}