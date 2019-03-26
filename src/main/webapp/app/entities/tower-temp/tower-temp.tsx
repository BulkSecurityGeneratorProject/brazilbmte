import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAllAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './tower-temp.reducer';
import { ITowerTemp } from 'app/shared/model/tower-temp.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ITowerTempProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export class TowerTemp extends React.Component<ITowerTempProps> {
  componentDidMount() {
    this.props.getEntities();
  }

  render() {
    const { towerTempList, match } = this.props;
    return (
      <div>
        <h2 id="tower-temp-heading">
          <Translate contentKey="brazilbmteApp.towerTemp.home.title">Tower Temps</Translate>
          <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
            <FontAwesomeIcon icon="plus" />&nbsp;
            <Translate contentKey="brazilbmteApp.towerTemp.home.createLabel">Create new Tower Temp</Translate>
          </Link>
        </h2>
        <div className="table-responsive">
          <Table responsive>
            <thead>
              <tr>
                <th>
                  <Translate contentKey="global.field.id">ID</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.towerNumber">Tower Number</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.serialNumber">Serial Number</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.longitude">Longitude</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.latitude">Latitude</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.altitude">Altitude</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.utmX">Utm X</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.utmY">Utm Y</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.progressiveDistance">Progressive Distance</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.isCorner">Is Corner</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.corner">Corner</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.spanDistance">Span Distance</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.towerType">Tower Type</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.folha">Folha</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.sirgas2000X">Sirgas 2000 X</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.sirgas2000Y">Sirgas 2000 Y</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.sirgas2000Cota">Sirgas 2000 Cota</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.condutorCota">Condutor Cota</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.pontosTower">Pontos Tower</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.utmCota">Utm Cota</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoA">Info A</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoB">Info B</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoC">Info C</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoDA">Info DA</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoDB">Info DB</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoDC">Info DC</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoDD">Info DD</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoE">Info E</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoF">Info F</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoG">Info G</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoHA">Info HA</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoHB">Info HB</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoHC">Info HC</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoIA">Info IA</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoIB">Info IB</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoIC">Info IC</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoID">Info ID</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoIE">Info IE</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoJ">Info J</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoKA">Info KA</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoKB">Info KB</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoKC">Info KC</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoKD">Info KD</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoKE">Info KE</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoKF">Info KF</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoL">Info L</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoM">Info M</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoN">Info N</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoOA">Info OA</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoOB">Info OB</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoP">Info P</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoQ">Info Q</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerTemp.infoR">Info R</Translate>
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {towerTempList.map((towerTemp, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${towerTemp.id}`} color="link" size="sm">
                      {towerTemp.id}
                    </Button>
                  </td>
                  <td>{towerTemp.towerNumber}</td>
                  <td>{towerTemp.serialNumber}</td>
                  <td>{towerTemp.longitude}</td>
                  <td>{towerTemp.latitude}</td>
                  <td>{towerTemp.altitude}</td>
                  <td>{towerTemp.utmX}</td>
                  <td>{towerTemp.utmY}</td>
                  <td>{towerTemp.progressiveDistance}</td>
                  <td>{towerTemp.isCorner}</td>
                  <td>{towerTemp.corner}</td>
                  <td>{towerTemp.spanDistance}</td>
                  <td>{towerTemp.towerType}</td>
                  <td>{towerTemp.folha}</td>
                  <td>{towerTemp.sirgas2000X}</td>
                  <td>{towerTemp.sirgas2000Y}</td>
                  <td>{towerTemp.sirgas2000Cota}</td>
                  <td>{towerTemp.condutorCota}</td>
                  <td>{towerTemp.pontosTower}</td>
                  <td>{towerTemp.utmCota}</td>
                  <td>{towerTemp.infoA}</td>
                  <td>{towerTemp.infoB}</td>
                  <td>{towerTemp.infoC}</td>
                  <td>{towerTemp.infoDA}</td>
                  <td>{towerTemp.infoDB}</td>
                  <td>{towerTemp.infoDC}</td>
                  <td>{towerTemp.infoDD}</td>
                  <td>{towerTemp.infoE}</td>
                  <td>{towerTemp.infoF}</td>
                  <td>{towerTemp.infoG}</td>
                  <td>{towerTemp.infoHA}</td>
                  <td>{towerTemp.infoHB}</td>
                  <td>{towerTemp.infoHC}</td>
                  <td>{towerTemp.infoIA}</td>
                  <td>{towerTemp.infoIB}</td>
                  <td>{towerTemp.infoIC}</td>
                  <td>{towerTemp.infoID}</td>
                  <td>{towerTemp.infoIE}</td>
                  <td>{towerTemp.infoJ}</td>
                  <td>{towerTemp.infoKA}</td>
                  <td>{towerTemp.infoKB}</td>
                  <td>{towerTemp.infoKC}</td>
                  <td>{towerTemp.infoKD}</td>
                  <td>{towerTemp.infoKE}</td>
                  <td>{towerTemp.infoKF}</td>
                  <td>{towerTemp.infoL}</td>
                  <td>{towerTemp.infoM}</td>
                  <td>{towerTemp.infoN}</td>
                  <td>{towerTemp.infoOA}</td>
                  <td>{towerTemp.infoOB}</td>
                  <td>{towerTemp.infoP}</td>
                  <td>{towerTemp.infoQ}</td>
                  <td>{towerTemp.infoR}</td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${towerTemp.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${towerTemp.id}/edit`} color="primary" size="sm">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${towerTemp.id}/delete`} color="danger" size="sm">
                        <FontAwesomeIcon icon="trash" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.delete">Delete</Translate>
                        </span>
                      </Button>
                    </div>
                  </td>
                </tr>
              ))}
            </tbody>
          </Table>
        </div>
      </div>
    );
  }
}

const mapStateToProps = ({ towerTemp }: IRootState) => ({
  towerTempList: towerTemp.entities
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(TowerTemp);
