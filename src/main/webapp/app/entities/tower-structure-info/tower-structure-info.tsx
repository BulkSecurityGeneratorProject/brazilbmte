import React from 'react';
import { connect } from 'react-redux';
import { Link, RouteComponentProps } from 'react-router-dom';
import { Button, Col, Row, Table } from 'reactstrap';
// tslint:disable-next-line:no-unused-variable
import { Translate, ICrudGetAllAction } from 'react-jhipster';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

import { IRootState } from 'app/shared/reducers';
import { getEntities } from './tower-structure-info.reducer';
import { ITowerStructureInfo } from 'app/shared/model/tower-structure-info.model';
// tslint:disable-next-line:no-unused-variable
import { APP_DATE_FORMAT, APP_LOCAL_DATE_FORMAT } from 'app/config/constants';

export interface ITowerStructureInfoProps extends StateProps, DispatchProps, RouteComponentProps<{ url: string }> {}

export class TowerStructureInfo extends React.Component<ITowerStructureInfoProps> {
  componentDidMount() {
    this.props.getEntities();
  }

  render() {
    const { towerStructureInfoList, match } = this.props;
    return (
      <div>
        <h2 id="tower-structure-info-heading">
          <Translate contentKey="brazilbmteApp.towerStructureInfo.home.title">Tower Structure Infos</Translate>
          <Link to={`${match.url}/new`} className="btn btn-primary float-right jh-create-entity" id="jh-create-entity">
            <FontAwesomeIcon icon="plus" />&nbsp;
            <Translate contentKey="brazilbmteApp.towerStructureInfo.home.createLabel">Create new Tower Structure Info</Translate>
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
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.folha">Folha</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.sirgas2000X">Sirgas 2000 X</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.sirgas2000Y">Sirgas 2000 Y</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.sirgas2000Cota">Sirgas 2000 Cota</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.condutorCota">Condutor Cota</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.pontosTower">Pontos Tower</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.utmCota">Utm Cota</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoA">Info A</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoB">Info B</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoC">Info C</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoDA">Info DA</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoDB">Info DB</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoDC">Info DC</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoDD">Info DD</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoE">Info E</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoF">Info F</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoG">Info G</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoHA">Info HA</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoHB">Info HB</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoHC">Info HC</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoIA">Info IA</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoIB">Info IB</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoIC">Info IC</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoID">Info ID</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoIE">Info IE</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoJ">Info J</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoKA">Info KA</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoKB">Info KB</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoKC">Info KC</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoKD">Info KD</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoKE">Info KE</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoKF">Info KF</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoL">Info L</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoM">Info M</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoN">Info N</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoOA">Info OA</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoOB">Info OB</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoP">Info P</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoQ">Info Q</Translate>
                </th>
                <th>
                  <Translate contentKey="brazilbmteApp.towerStructureInfo.infoR">Info R</Translate>
                </th>
                <th />
              </tr>
            </thead>
            <tbody>
              {towerStructureInfoList.map((towerStructureInfo, i) => (
                <tr key={`entity-${i}`}>
                  <td>
                    <Button tag={Link} to={`${match.url}/${towerStructureInfo.id}`} color="link" size="sm">
                      {towerStructureInfo.id}
                    </Button>
                  </td>
                  <td>{towerStructureInfo.folha}</td>
                  <td>{towerStructureInfo.sirgas2000X}</td>
                  <td>{towerStructureInfo.sirgas2000Y}</td>
                  <td>{towerStructureInfo.sirgas2000Cota}</td>
                  <td>{towerStructureInfo.condutorCota}</td>
                  <td>{towerStructureInfo.pontosTower}</td>
                  <td>{towerStructureInfo.utmCota}</td>
                  <td>{towerStructureInfo.infoA}</td>
                  <td>{towerStructureInfo.infoB}</td>
                  <td>{towerStructureInfo.infoC}</td>
                  <td>{towerStructureInfo.infoDA}</td>
                  <td>{towerStructureInfo.infoDB}</td>
                  <td>{towerStructureInfo.infoDC}</td>
                  <td>{towerStructureInfo.infoDD}</td>
                  <td>{towerStructureInfo.infoE}</td>
                  <td>{towerStructureInfo.infoF}</td>
                  <td>{towerStructureInfo.infoG}</td>
                  <td>{towerStructureInfo.infoHA}</td>
                  <td>{towerStructureInfo.infoHB}</td>
                  <td>{towerStructureInfo.infoHC}</td>
                  <td>{towerStructureInfo.infoIA}</td>
                  <td>{towerStructureInfo.infoIB}</td>
                  <td>{towerStructureInfo.infoIC}</td>
                  <td>{towerStructureInfo.infoID}</td>
                  <td>{towerStructureInfo.infoIE}</td>
                  <td>{towerStructureInfo.infoJ}</td>
                  <td>{towerStructureInfo.infoKA}</td>
                  <td>{towerStructureInfo.infoKB}</td>
                  <td>{towerStructureInfo.infoKC}</td>
                  <td>{towerStructureInfo.infoKD}</td>
                  <td>{towerStructureInfo.infoKE}</td>
                  <td>{towerStructureInfo.infoKF}</td>
                  <td>{towerStructureInfo.infoL}</td>
                  <td>{towerStructureInfo.infoM}</td>
                  <td>{towerStructureInfo.infoN}</td>
                  <td>{towerStructureInfo.infoOA}</td>
                  <td>{towerStructureInfo.infoOB}</td>
                  <td>{towerStructureInfo.infoP}</td>
                  <td>{towerStructureInfo.infoQ}</td>
                  <td>{towerStructureInfo.infoR}</td>
                  <td className="text-right">
                    <div className="btn-group flex-btn-group-container">
                      <Button tag={Link} to={`${match.url}/${towerStructureInfo.id}`} color="info" size="sm">
                        <FontAwesomeIcon icon="eye" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.view">View</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${towerStructureInfo.id}/edit`} color="primary" size="sm">
                        <FontAwesomeIcon icon="pencil-alt" />{' '}
                        <span className="d-none d-md-inline">
                          <Translate contentKey="entity.action.edit">Edit</Translate>
                        </span>
                      </Button>
                      <Button tag={Link} to={`${match.url}/${towerStructureInfo.id}/delete`} color="danger" size="sm">
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

const mapStateToProps = ({ towerStructureInfo }: IRootState) => ({
  towerStructureInfoList: towerStructureInfo.entities
});

const mapDispatchToProps = {
  getEntities
};

type StateProps = ReturnType<typeof mapStateToProps>;
type DispatchProps = typeof mapDispatchToProps;

export default connect(
  mapStateToProps,
  mapDispatchToProps
)(TowerStructureInfo);
